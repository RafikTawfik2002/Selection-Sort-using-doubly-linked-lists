public class DLLNode<T> {
	public T key;
	public DLLNode<T> next;
	public DLLNode<T> prev;
    public DLLNode<T> head;
    public DLLNode<T> tail;
	
	public DLLNode(T init) {
		key = init;
		next = null;            
		prev = null;
		head = this;
		tail = this;
        head.next = next;
        head.prev = next;
        tail.next = next;
        tail.prev = prev;
	}

	public void append(T value) {
		DLLNode<T> newNode = new DLLNode<T>(value);
		tail.next = newNode;
		newNode.prev = tail;
		newNode.next = null;
		tail = newNode;
	}

	public DLLNode<T> find(T key){
		DLLNode<T> found = this.head;

		while(key != found.key && found.next != null){
			found = found.next;
		}
		return found;
	}

	public String toString(){
		DLLNode<T> x = head;
		String ls = "[ " + x.key;
		while (x.next != null){
			x = x.next;
			ls += " " + x.key;
		}
		return ls + " ]";
	}

	public void printLs(){
		System.out.println(toString() +" " + "Head: "+this.head.key+" Tail: " + this.tail.key+ "\n");
	}
}