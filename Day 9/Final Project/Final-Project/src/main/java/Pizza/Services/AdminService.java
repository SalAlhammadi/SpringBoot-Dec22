package Pizza.Services;

import Pizza.Models.User.Admin;
import Pizza.Repos.AdminRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepo admins;

    public void addAdmin(Admin admin){
        admins.save(admin);

    }
    public List<Admin> getAll(){
        return admins.findAll();

    }
    public boolean isAdmin(Integer id){
        List<Admin> currentAdmins = admins.findAll();
        for (Admin admin: currentAdmins) {
            if (admin.getId()==(id))
                return true;
        }
        return false;
    }
    public void deleteAdmin(Integer id){
        admins.findAll().remove(id);
    }

    public void updateAdmin(Integer id, Admin Admin){
        admins.findAll().set(id,Admin);
    }


}
