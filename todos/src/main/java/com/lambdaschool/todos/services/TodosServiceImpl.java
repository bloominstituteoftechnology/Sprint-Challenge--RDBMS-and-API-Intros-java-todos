package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.models.User;
import com.lambdaschool.todos.repository.TodosRepository;
import com.lambdaschool.todos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "todosService")
public class TodosServiceImpl implements TodosService
{
    @Autowired
    private TodosRepository todosrepos;

    @Autowired
    private UserRepository userrepos;

    @Override
    public void markComplete(long todoid)
    {

    }

//    @Override
//    public Todos update(
//        long todoid,
//        String description,
//        String completed,
//        User user)
//    {
//        @Transactional
//        @Override
//        public Todos update(
//        long todoid,
//        String description,
//        String completed,
//        User user)
//        {
//            User currentUser = findUserById(userid);
//
//            if (user.get() != null)
//            {
//                currentUser.setUsername(user.getUsername()
//                    .toLowerCase());
//            }
//
//            if (user.getPassword() != null)
//            {
//                currentUser.setPassword(user.getPassword());
//            }
//
//            if (user.getPrimaryemail() != null)
//            {
//                currentUser.setPrimaryemail(user.getPrimaryemail()
//                    .toLowerCase());
//            }
//
//            if (user.getRoles()
//                .size() > 0)
//            {
//                currentUser.getRoles()
//                    .clear();
//                for (UserRoles r : user.getRoles())
//                {
//                    Role newRole = roleService.findRoleById(r.getRole().getRoleid());
//
//                    currentUser.getRoles()
//                        .add(new UserRoles(currentUser, newRole));
//                }
//            }
//
//            if (user.getUseremails()
//                .size() > 0)
//            {
//                currentUser.getUseremails()
//                    .clear();
//                for (Useremail ue : user.getUseremails())
//                {
//                    currentUser.getUseremails()
//                        .add(new Useremail(currentUser,
//                            ue.getUseremail()));
//                }
//            }
//
//            return userrepos.save(currentUser);
//        }
//        return null;
//    }
}
