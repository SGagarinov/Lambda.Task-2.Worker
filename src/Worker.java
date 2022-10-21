public class Worker {
    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void work() {

        for (int i = 0; i < 100; i++) {
            try {
                if (i == 33) throw new RuntimeException("Worker  is tired");
                callback.onDone("Work " + i + " is done");
            } catch (Exception ex) {
                errorCallback.onError("Task error:  " + ex.getMessage());
            }
        }
    }
}
