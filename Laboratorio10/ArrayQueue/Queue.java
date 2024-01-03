public interface Queue extends Container{
    void enqueue(Object obj); // add a new elemento to the queue
    Object dequeue(); // remove the first elemento of the queue
    Object getFront(); // get the first element of the queue
}

class EmptyQueueException extends RuntimeException{} 
class FullQueueException extends RuntimeException{} 
