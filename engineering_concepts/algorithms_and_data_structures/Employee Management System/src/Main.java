public class Main {

    Employee employee[];
    int size;

    Main(int n){
        employee = new Employee[n];
        size = -1;
    }

    void add(String a, String b, String c, double s){
        if(size==employee.length){
            System.err.println("Array is full!");
            return;
        }
        size++;
        employee[size] = new Employee(a, b, c, s);
    }

    int search(String id){
        for(int i=0; i<=size; i++){
            if(employee[i].id==id) return i;
        }
        return -1;
    }

    void delete(String id){
        int search = search(id);
        if(search==-1){
            System.err.println("delete not possible as no such Id exists");
            return;
        }
        for(int i=search; i<=size; i++){
            employee[i].id = employee[i+1].id;
            employee[i].name = employee[i+1].name;
            employee[i].position = employee[i+1].position;
            employee[i].salary = employee[i+1].salary;
        }
    }
}
