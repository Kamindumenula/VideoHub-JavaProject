package videoHubPackage;

import java.util.List;

public interface AdminService {
    List<AdminModel> getByID(String userId);
}
