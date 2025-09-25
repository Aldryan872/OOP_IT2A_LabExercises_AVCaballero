import java.util.List;

public interface DataManageable<T> {
    void addData(T item);

    void updateData(T item);

    void deleteData(String id);

    T getData(String id);

    List<T> getAllData();

    // Static method in interface
    static void showDataManagementInfo() {
        System.out.println("This interface manages health system data");
    }
}