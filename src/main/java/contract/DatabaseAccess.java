package contract;

import com.google.inject.ImplementedBy;
import implementation.DatabaseAccessImpl;

@ImplementedBy(DatabaseAccessImpl.class)// Just-in-time binding
public interface DatabaseAccess {
    void someAction();
}
