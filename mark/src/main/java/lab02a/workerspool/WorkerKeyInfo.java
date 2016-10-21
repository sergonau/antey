package lab02a.workerspool;

import static lab02a.common.Utils.isStrEmpty;
/**
 * Created by Mark Lobanov on 20.10.2016.
 */
public class WorkerKeyInfo {
    private String workerKey;

    public WorkerKeyInfo(String workerKey) {
        if ( !isStrEmpty( workerKey ) ) {
            this.workerKey = workerKey;
        } else {
            throw new IllegalArgumentException("Parameter workerKey can't be null or empty");
        }
    }

    public String getWorkerKey() {
        return workerKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o == null) || (getClass() != o.getClass())) return false;

        return getWorkerKey().equals( ((WorkerKeyInfo) o).getWorkerKey() );
    }

    @Override
    public int hashCode() {
        return getWorkerKey().hashCode();
    }
}
