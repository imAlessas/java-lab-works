public interface Stack extends Container{
    Object top(); // get the top element
    Object pop(); // remove the top element
    void push(Object obj); // add a new element
}

class EmptyStackException extends RuntimeException{}
class FullStackException extends RuntimeException{}
