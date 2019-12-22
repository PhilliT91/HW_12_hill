public class Collection implements CustomCollection {
    private String[] arr;

    private int capacity;
    private int lenght = 0;

    Collection() {
        capacity = 20;
        arr = new String[capacity];
    }

    Collection(int capacity) {
        if(capacity==0){
            System.out.print("must be at least 1 element!");
            this.capacity=1;
        }
        else{
            this.capacity = capacity;
        }
        arr = new String[capacity];
    }

    public int size() {
        int i = 0;
        for (; i < capacity; i++) {
            if (arr[i] != null) {
                continue;
            } else  break;


        }
        return i;
    }


    public boolean add(String str) {
        if (lenght == capacity - 1) {
            capacity *= 2;
            String[] temp = new String[capacity];
            for (int i = 0; i < lenght; i++){
                temp[i] = arr[i];
            }

            arr = temp;
        }

        arr[lenght] = str;
        lenght++;
        return true;
    }

    public boolean addByOne(String str) {
        if (lenght == capacity - 1) {
            capacity += 1;
            String[] temp = new String[capacity];
            for (int i = 0; i < lenght; i++) {
                temp[i] = arr[i];

            }

            arr = temp;
        }

        arr[lenght] = str;
        lenght++;
        return true;
    }





    public boolean delete(int index) {
        if (index >= lenght) {
            return false;
        }
        for (int i = index; i < lenght - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[lenght - 1] = null;
        lenght--;
        return true;
    }


    public boolean delete(String str) {
        if (!this.contains(str)) {
            return false;
        }

        for (int i = 0; i < lenght; i++) {
            if (arr[i].equals(str)) {
                delete(i);
            }
            arr[lenght - 1] = null;
            lenght--;
        }
        return true;


    }


    public String get(int index) {
        if (index >= lenght) {
            return "";
        }


        return arr[index];


    }

    public boolean contains(String str) {
        for (int i = 0; i < lenght; i++) {
            if (arr[i].equals(str)) {
                return true;
            }
        }

        return false;

    }


    void display() {
        for (int i = 0; i < lenght; i++) {
            System.out.print(arr[i] + ", ");
        }
      //  System.out.println("");


    }

    public boolean compare(Collection eColl) {
        if(this==eColl)return true;

        if (this.size() != eColl.size()) return false;



            for (int i = 0; i < lenght; i++) {
                if (!this.get(i).equals(eColl.get(i))) {
                    return false;
                }
            }
            return true;




    }

    public boolean clear() {
        for (int i = 0; i <lenght; i++) {
            this.arr[i] = null;

        }
        lenght=1;
        return true;
    }

    int indexOf(String str) {
        for (int i = 0; i < lenght; i++) {
            if (arr[i].equals(str)) {
                return i;
            }
        }
        System.out.println("no matches");
        return -1;

    }


    public boolean addAll(String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            this.add(strArr[i]);
        }
        return true;


    }

    public boolean addAll(Collection strColl) {
        for (int i = 0; i < strColl.size(); i++) {
            this.add(strColl.get(i));
        }
        return true;
    }


    public boolean trim() {

        return false;


    }





}














