package org.example;
/**
 класс List представляет собой однозвязный список
 @param <T> тип данных элментов списка
 */
public class List<T> {
    /**
     вложенный класс, элемент которого представляет собой узел односвязного списка
     @param <T> тип данных узла(такой же как и у всего списка,очевидно)
     */
    public class Node<T>{
        /**
         информационное поле
         */
        private T info;
        /**
         ссылка на следующий узел
         */
        private Node<T> next;
        /**
         конструктор по умолчанию
        */
        Node(){
            info=null;
            next=null;
        }
        /**
         конструктор по передаваемому значению
         @param x - значение, которое примет информационное поле info узла
         */
        Node(T x){
            info=x;
            next=null;
        }
        /**
         перегруженный метод toString класса Object
         @return символьное представление информационного поля узла
         */
        @Override
        public String toString(){

            return info.toString();
        }
    }

    /**
     узел, содержащий в себе первый элемент списка ("голову списка")
     */
    private Node<T> head;

    /**
     количество элементов в списке
     */
    private int size;

    /**
     конструктор по умолчанию
     */
    List(){
        head=null;
        size=0;
    }

    /**
     метод добавления элемента в ночало списка
     @param x - добавляемое значение
     */
    public void push_begin(T x){
            Node <T> p=new Node<>(x);
            p.next=head;
            head=p;
        size++;
    }

    /**
     метод добавления элемента в конец списка
     @param x - добавляемое значение
     */
    public void push_back(T x){
        if(head==null){
            head=new Node<>(x);
        }
        else{
            Node<T> p=new Node<>(x);
            Node<T> q=head;
            while(q.next!=null){
                q=q.next;
            }
            q.next=p;
        }
        size++;
    }

    /**
     метод добавления элемента перед указанным узлом в списке
     @param x - добавляемое значение
     @param y - узел, перед которым нужно поместить новое значение
     @throws IllegalArgumentException() - указанного узла y в данном списке не существует
     */
    public void insert_before(T x, Node<T> y){
        if(y==null){
            push_back(x);
            return;
        }
        else{
            if(head==y){
                push_begin(x);
                return;
            }
            else {
                Node<T> q = head;
                Node<T> p = new Node<>(x);
                boolean f = false;
                while (q.next != null&&!f) {
                    if (q.next == y) {
                        p.next=q.next;
                        q.next=p;
                        f=true;
                        size++;
                    }
                    q = q.next;
                }
                if(!f){
                    throw new IllegalArgumentException();
                }
            }
        }
        return;
    }

    /**
     метод добавления элемента после указанного узла в списке
     @param x - добавляемое значение
     @param y - узел, после которого нужно поместить новое значение
     @throws IllegalArgumentException() - указанного узла y в данном списке не существует
     */
    public void insert_after(T x,Node y){
        if(y==null){
            push_begin(x);
            return;
        }
        else{
            Node<T> p=new Node<> (x);
            Node<T> q=head;
            boolean f=false;
            while(q!=null){
                if(q==y){
                    p.next=q.next;
                    q.next=p;
                    f=true;
                    size++;
                }
                q=q.next;
            }
            if(!f){
                throw new IllegalArgumentException();
            }
        }
        return;
    }

    /**
     метод, позволяющий найти узел, содержащий интересуемое значение
     @param x - интересуемое значение
     @peturn - узел, содержащий указанное значение
     @throws IllegalArgumentException() - указанного значения в данном списке не существует
     */
    public Node<T> search_node(T x){
        Node<T>q=head;
        Node<T> k=null;
        boolean f=false;
        while(q!=null&&!f){
            if(q.info==x){
                k= q;
                f=true;
            }
            q=q.next;
        }
        if(!f){
            throw new IllegalArgumentException();
        }
        else {
            return k;
        }
    }

    /**
     метод удаления начального узла в списке
     @return - удаленное значение
     @throws IndexOutOfBoundsException() - список пуст
     */
    public T delete_begin(){
        if(head!=null){
            head=head.next;
            size--;
            return head.info;
        }
        else{
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     метод удаления последнего узла в списке
     @return - удаленное значение
     @throws IndexOutOfBoundsException() - список пуст
     */
    public T delete_back(){
        Node<T> p=head;
        if(head!=null){
            if(head.next==null){
                head=null;
            }
            else {
                Node<T> q = head;
                if(size==2){
                    p=head.next;
                    size--;
                    head.next=null;
                }
                else{
                    while (q.next.next != null){
                        q=q.next;
                    }
                    p=q.next;
                    size--;
                    q.next=null;
                }
            }
        }
        if(p==null){
            throw new IndexOutOfBoundsException();
        }
        else {
            return p.info;
        }
    }

    /**
     метод удаления узла в списке перед указанным узлом у
     @param y - узел, перед которым нужно удалить значение
     @return - удаленное значение
     @throws IndexOutOfBoundsException() - список пуст, либо указанный узел у является головой списка
     @throws IllegalArgumentException() - указанный узел в данном списке не существует
     */
    public T delete_before(Node<T> y){

        Node<T> p=null;
        if(y==null){
           p= new Node<>(delete_back());
        }
        else{
            if(head==null||head==y){
                throw new IndexOutOfBoundsException();
            }
            else {
                Node<T> q = head;
                boolean f = false;
                if(head.next==y){
                    p=head;
                    head=head.next;
                    size--;
                }
                else {
                    while (q.next != null && !f) {
                        if (q.next.next == y) {
                            f = true;
                            p = q.next;
                            q.next = q.next.next;
                            size--;
                        }
                        q = q.next;
                    }
                    if (!f) {
                        p = null;
                        throw new IllegalArgumentException();
                    }
                }
            }
        }
        if(p==null){
            throw new IndexOutOfBoundsException();
        }
        else{
            return p.info;
        }
    }

    /**
     метод возвращающий количество элементов списка
     @return - количество элементов списка
     */
    public int size(){
        return size;
    }

    /**
     метод удаления узла в списке после указанного узла у
     @param y - узел, после которого нужно удалить значение
     @return - удаленное значение
     @throws IndexOutOfBoundsException() - список пуст
     @throws IllegalArgumentException() - указанный узел в данном списке не существует
     */
    public  T delete_after(Node<T> y){
        Node<T> p=null;
        if(head==null){
            throw new IndexOutOfBoundsException();
        }
        else{
            if(y==null){
                p=new Node<>( delete_begin());
            }
            else {
                Node<T> q = head;
                boolean f = false;
                while (q != null && !f) {
                    if (q == y) {
                        p = q.next;
                        f = true;
                        if (q.next != null) {
                            size--;
                            q.next = q.next.next;
                        }
                        else{
                            throw new IndexOutOfBoundsException();
                        }
                    }
                   q=q.next;
                }
                if(!f){
                    throw new IllegalArgumentException();
                }
            }
            return p.info;
        }
    }


    /**
     метод удаления узла, имеющего указанный индекс (индексы списка начинаются с 0)
     @param ind - индекс удаляемого узла
     @return - удаленное значение
     @throws IndexOutOfBoundsException() - список пуст,
                либо указанный индекс выходит за пределы списка или является отрицательным
     */
    public T delete_index(int ind){//начинаем с нуля
        if(ind<=0||ind>=size||head==null){
            throw new IndexOutOfBoundsException();
        }
        else{
            Node<T> q=head;
            Node<T>p=null;
            T x=null;
            int count=0;
            if(ind==0){
                return delete_begin();
            }
            else {
                boolean f=false;
                while (q != null&&!f) {
                    if (count == ind){
                        x=q.info;
                        Node<T> k=q.next;
                        p.next=q.next;
                        q=k;
                        f=true;
                        size--;
                    }
                    else {
                        p = q;
                        q=q.next;
                    }
                    count++;
                }
                return x;
            }
        }
    }

    /**
     метод очищения списка (удаление всех элементов)
     */
    public void clean(){
        head=null;
        size=0;
    }

    /**
     метод нахождения первого элемента списка
     @return - указатель на голову списка
     */
    public Node<T> begin(){
        return head;
    }

    /**
     метод нахождения следующего узла, после последнего узла списка
     @return - узел, на который казывает последний элемнт
     */
    public Node<T> end(){
        Node<T> p=head;
        while(p!=null){
            p=p.next;
        }
        return p;
    }

    /**
     метод проверки списка на пустоту
     @return true - если список пуст; false - если список не пуст
     */
   public boolean isEmpty(){
        if(size==0)
            return true;
        else
            return false;
   }

    /**
     метод нахождения индекса указанного узла (начиная с 0)
     @param y - узел, индекс которого нужно найти
     @return - индекс указанного узла в данном списке, начиная с 0
     @throws IndexOutOfBoundsException() - список пуст
     @throws IllegalArgumentException() - указанный узел в данном списке не существует, либо является нулевым указателем
     */
   public int index(Node<T> y){
        if(y==null){
            throw new IllegalArgumentException();
        }
        else{
            if(head==null){
                throw new IndexOutOfBoundsException();
            }
            Node<T> q=head;
            int count=0;
            boolean f=false;
            while(q!=null&&!f){
                if(q==y){
                    f=true;
                }
                q=q.next;
                count++;
            }
            if(!f){
                throw new IllegalArgumentException();
            }
            else{
                return count-1;
            }
        }
   }

    /**
     метод подсчета указанного значения
     @param x - значение, количество вхождений которого в список нужно посчитать
     @return - количество вхождений указанного элемента в список
     */
   public int count(T x){
        if(head==null){
            throw new IndexOutOfBoundsException();
        }
        else{
            Node<T> p=head;
            int count=0;
            while(p!=null){
                if(p.info==x){
                    count++;
                }
                p=p.next;
            }
            return count;
        }
   }

    /**
     перегруженный метод toString класса Object
     @return символьное представление элементов списка
     */
    @Override
    public String toString(){
        if(size==0){
            return "список пуст";
        }
        else {
            String str = "";
            Node<T> q = head;
            while (q != null) {
                str += q.toString() + " ";
                q = q.next;
            }
            return str;
        }
    }
}