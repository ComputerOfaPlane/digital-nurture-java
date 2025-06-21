public class Main {

    private Order order[];

    public static void main(String[] args) {
        System.err.println();
        Main obj1 = new Main(10);
        Main obj2 = new Main(15);
        obj1.bubbleSort();
        obj2.quickSort();
        obj1.displayAll();
        obj2.displayAll();
    }

    private void bubbleSort(){
        for (int i = 0; i < order.length - 1; i++) {
            boolean moreNeeded = false;
            for (int j = 0; j < order.length - i - 1; j++) {
                if (order[j].getTotalPrice() > order[j + 1].getTotalPrice()) {
                    Order temp = order[j];
                    order[j] = order[j + 1];
                    order[j + 1] = temp;
                    moreNeeded = true;
                }
            }
            if(!moreNeeded) break;
        }
    }

    private void quickSort(){
        quickSortHelper(0, order.length - 1);
    }

    private void quickSortHelper(int low, int high){
        if (low < high) {
            int pi = partition(low, high);
            quickSortHelper(low, pi - 1);
            quickSortHelper(pi + 1, high);
        }
    }

    private int partition(int low, int high){
        double pivot = order[high].getTotalPrice();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (order[j].getTotalPrice() <= pivot) {
                i++;
                Order temp = order[i];
                order[i] = order[j];
                order[j] = temp;
            }
        }
        Order temp = order[i + 1];
        order[i + 1] = order[high];
        order[high] = temp;
        return i + 1;
    }

    Main(int n){

        order = new Order[n];

        String[] ids = {
            "P01", "P02", "P03", "P04", "P05", "P06", "P07", "P08", "P09", "P10",
            "P11", "P12", "P13", "P14", "P15", "P16", "P17", "P18", "P19", "P20",
            "P21", "P22", "P23", "P24", "P25", "P26", "P27", "P28", "P29", "P30",
            "P31", "P32", "P33", "P34", "P35", "P36", "P37", "P38", "P39", "P40",
            "P41", "P42", "P43", "P44", "P45", "P46", "P47", "P48", "P49", "P50"
        };
        String[] names = {
            "Laptop", "Smartphone", "Headphones", "Tablet", "Monitor", "Mouse", "Keyboard", "Camera", "Speaker", "Printer",
            "Router", "Charger", "Power Bank", "Webcam", "Microphone", "Smartwatch", "Projector", "Scanner", "Modem", "Joystick",
            "VR Headset", "Fitness Tracker", "Hard Disk", "Pen Drive", "Memory Card", "Graphics Card", "Processor", "Motherboard", "RAM", "SSD",
            "Cooling Fan", "Tripod", "Flashlight", "Bluetooth Dongle", "E-Reader", "TV Stick", "Streaming Box", "Game Controller", "Smart Bulb", "WiFi Repeater",
            "Ink Cartridge", "Screen Protector", "Case Cover", "Laptop Stand", "Drawing Tablet", "Smart Plug", "Drone", "Smart Glasses", "Robot Vacuum", "3D Printer"
        };
        double[] prices = {
            599.99, 799.49, 199.95, 349.00, 499.99, 250.75, 150.50, 1200.00, 875.25, 1099.99,
            699.00, 399.49, 999.99, 429.90, 310.50, 899.99, 1249.99, 780.20, 349.95, 265.60,
            2299.99, 499.00, 1024.75, 150.00, 89.99, 2149.99, 3499.95, 2800.00, 999.00, 1500.00,
            350.00, 120.00, 75.50, 299.99, 649.00, 549.99, 1050.00, 399.99, 189.00, 225.00,
            80.00, 25.00, 60.00, 145.00, 740.00, 349.99, 4499.99, 1999.99, 8999.99, 15000.00
        };

        for(int i=0; i<n; ++i){
            order[i] = new Order(ids[getRandomNumber(0, 50)], names[getRandomNumber(0, 50)], prices[getRandomNumber(0, 50)]);
        }
    }

    private void displayAll(){
        System.out.print("\nOrders = \n");
        for(int i=0; i<order.length; i++){
            System.out.println(order[i].display());
        }
        System.out.println("-----------------------------------------------");
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

}