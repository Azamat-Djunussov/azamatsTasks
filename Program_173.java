package matem2.task_174;

// решение Джунусова Азамата
class Program_173{
    list_node first;  // первый узел
    list_node last;   // последний узел
    static int general_count = 0; // для задания размера массива объектов

    public static void main(String args[]){
        Program_173 list_1 = new Program_173();// создаем лист #1
        list_1.insert_last(4);
        list_1.insert_last(10);
        list_1.insert_last(15);
        list_1.insert_last(16);

        Program_173 list_2 = new Program_173();// создаем лист #2
        list_2.insert_last(2);
        list_2.insert_last(3);
        list_2.insert_last(4);
        list_2.insert_last(8);

        Program_173 list_3 = new Program_173();// создаем лист #3
        list_2.insert_last(3);
        list_2.insert_last(5);
        list_2.insert_last(6);
        list_2.insert_last(7);

        System.out.println("##################################################################");

        Program_173 unin = new Program_173();
        unin.get_union(list_1.first);//сортируем список
        unin.get_union(list_2.first);//сортируем и объединяем список
        unin.get_union(list_3.first);//сортируем и объединяем список
        unin.display_list();// распечтаываем лист list_3, который включает в себя: list_1, list_2

        System.out.println("Object_###########################################################");
        // массив объектов - необязательно, в качестве бонуса.
        Object[] array;
        array = unin.object_display_list(general_count);

        for (Object i1:array) {
            System.out.print(i1 + " ");
        }
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
//     Узел связанного списка
    class list_node {
        int data;
        list_node next;

        list_node(int data){
            this.data = data;
            next = null;
        }

        public String toString() {
            return ""+data;
        }
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
//    Функция вставляет узел в конец связанного списка
    private void insert_last(int key){  // insert at end of list
        list_node newLink = new list_node(key);   // make new link
        if(first ==null)                // if empty list,
            first = newLink;            // first --> newLink
        else
            last.next = newLink;        // old last --> newLink
        last = newLink;                // newLink <-- last
        general_count++;
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
//    Функция для сортировки списка
    public void insert(int key){
        list_node newLink = new list_node(key);
        list_node previous = null;
        list_node current = first;

        while(current != null && key >= current.data){
            previous = current;
            current = current.next;
        }
        if(previous==null)
            first = newLink;
        else
            previous.next = newLink;
        newLink.next = current;
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
//    Функция для объединения списков
    public void get_union(list_node list_x){
        list_node t1 = list_x;
        while (t1 != null){
            insert(t1.data);
            t1 = t1.next;
        }
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
//    Функция для загрузки объектов в массив
    public Object[] object_display_list(int general_count){
        int count = 0;
        Object[] array = new Object[general_count];

        list_node current = first;
        while(current != null){
            array[count] = current;
            count++;
            current = current.next;  // move to next link
        }
        return array;
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
//     Утилита для печати списка
    public void display_list(){
        list_node current = first;
        while(current != null){
//            current.display_link();   // print data
            System.out.print( current.data + " ");
            current = current.next;  // move to next link
        }
        System.out.println();
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
}
