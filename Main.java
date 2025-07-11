// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {
  public static void main(String[] args) {
    Node node3 = new Node(3);
    Node node2 = new Node(2, node3);
    Node node1 = new Node(1, node2);
    node1.addLast(4);
    node1.addLast(5);
    node1.addLast(6);
    int arr[] = { 7, 8, 9, 10 };
    node1.addLast(arr);
    System.out.println(node1);
    System.out.println(node1.multiply());
    System.out.println(node1.multiply2());

    System.out.println(node1.addFirst(0).addFirst(-1).addFirst(-2));

  }

}

class Node {
  int value;
  Node next;

  public Node(int value, Node next) {
    this.value = value;
    this.next = next;
  }

  public Node(int value) {
    this.value = value;
  }

  public String toString() {

    if (this.next != null)
      return this.value + "," + this.next.toString();
    else
      return value + "";
  }

  public int sum() {
    Node current = this;
    int sum = 0;
    while (current != null) {
      sum = sum + current.value;
      current = current.next;
    }
    return sum;
  }

  public int sumRec() {
    if (this.next == null)
      return this.value;
    else
      return this.value + this.next.sumRec();
  }

  public void addLast(int num) {
    Node current = this;
    while (current.next != null)
      current = current.next;
    current.next = new Node(num);

  }

  public void addLast(int[] arr) {
    Node current = this;
    while (current.next != null)
      current = current.next;
    for (int i = 0; i < arr.length; i++) {
      current.next = new Node(arr[i]);
      current = current.next;
    }

  }

  // public void addLast(int[] arr) {
  // for(int i=0; i<arr.length; i++) this.addLast(arr[i]);
  // }
  public int multiply() {
    if (this.next == null)
      return this.value;
    return this.value * this.next.multiply();

  }

  public int multiply2() {
    int mul = 1;
    Node current = this;
    do {
      mul = mul * current.value;
      current = current.next;
    } while (current != null);

    return mul;

  }

  public Node addFirst(int num) {
    Node newNode = new Node(num, this);
    return newNode;
  }
}
