package com.bionic.socialNetwork.logic.lists;

import com.bionic.socialNetwork.dao.impl.BackOfficeAdminDaoImpl;
import com.bionic.socialNetwork.dao.impl.PostDaoImpl;
import com.bionic.socialNetwork.models.BackOfficeAdmin;
import com.bionic.socialNetwork.models.Post;
import org.codehaus.jackson.annotate.JsonIgnore;


import java.util.Collection;
import java.util.List;

/**
 * NewsList logic
 *
 * @author Matvey Mitnitskyi
 * @version 1.00 created 23.07.2014.
 */
public class NewsList {
    @JsonIgnore
    private int newsListNumber;
    @JsonIgnore
    private PostDaoImpl postDao;
    private List<Post> posts;

    public NewsList(int newsNumber) {
        this.newsListNumber = newsNumber;
        try {
        BackOfficeAdminDaoImpl backOfficeAdminDao =
                new BackOfficeAdminDaoImpl();
        postDao = new PostDaoImpl();
        posts = postDao.selectLastBeckOffWith(backOfficeAdminDao.selectAll(),
                                              newsListNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<Post> getPosts() {
        return posts;
    }
}