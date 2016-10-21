package lab02a.workerspool;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by Mark Lobanov on 20.10.2016.
 */
public class WorkersPool {
    private Map<WorkerKeyInfo, IWorkRunnable> workersMap = new HashMap<>();

    public IWorkRunnable getWorker(String key) {
        return workersMap.get( new WorkerKeyInfo( key ) );
    }

    public IWorkRunnable addWorker(WorkerKeyInfo key, IWorkRunnable value) {
        return workersMap.put(key, value);
    }

    public void clear() {
        workersMap.clear();
    }
}
