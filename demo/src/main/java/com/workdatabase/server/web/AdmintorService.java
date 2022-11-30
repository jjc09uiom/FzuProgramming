package com.workdatabase.server.web;


import com.workdatabase.domain.Admintor;
import com.workdatabase.domain.AdmintorExample;
import com.workdatabase.exception.BusinessException;
import com.workdatabase.exception.BusinessExceptionCode;
import com.workdatabase.mapper.AdmintorMapper;
import com.workdatabase.req.AdmintorLoginReq;
import com.workdatabase.resp.AdmintorLoginResp;
import com.workdatabase.util.CopyUtil;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdmintorService {

    @Resource
    private AdmintorMapper admintorMapper;


  /*  public PageResp<UserQueryResp> list(UserQueryReq req) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();

        if (!ObjectUtils.isEmpty(req.getLoginName())) {
            criteria.andLoginNameEqualTo(req.getLoginName());
        }

        PageHelper.startPage(req.getPage(), req.getSize());
        //现在还是User类
        List<User> userlist = userMapper.selectByExample(userExample);

        PageInfo<User> pageInfo = new PageInfo<>(userlist);
        pageInfo.getTotal();

        //  List<UserResp> resplist=new ArrayList<>();
    *//*    for(User user:list){

    //原来的单个拷贝
            UserResp userResp = new UserResp();
            userResp.setId(user.getId());
            BeanUtils.copyProperties(user,userResp);

           UserResp userResp= CopyUtil.copy(user,UserResp.class);

            resplist.add(userResp);
        }*//*

        List<UserQueryResp> list = CopyUtil.copyList(userlist, UserQueryResp.class);

        PageResp<UserQueryResp> pageResp = new PageResp<>();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);
        return pageResp;
    }
*/

   /* public void save(UserSaveReq req) {

        User user = CopyUtil.copy(req, User.class);

        if (ObjectUtils.isEmpty(req.getId())) {
            //判断登录账户是否为空
            if (ObjectUtils.isEmpty(selectByLoginName(req.getLoginName()))) {
                //新增
                user.setId(snowFlake.nextId());
                userMapper.insert(user);
            } else {
                //登录账户存在
                throw new BusinessException(BusinessExceptionCode.USER_LOGIN_NAME_EXIST);
            }
        } else {
            //更新
            user.setLoginName(null);
            userMapper.updateByPrimaryKeySelective(user);
        }

    }*/


  /*  public void delete(long id) {
        userMapper.deleteByPrimaryKey(id);
    }*/

    public Admintor selectByLoginName(String Admin) {
        AdmintorExample userExample = new AdmintorExample();
        AdmintorExample.Criteria criteria = userExample.createCriteria();
        criteria.andAdminEqualTo(Admin);
        //mybatis只能用列表
        List<Admintor> userList = admintorMapper.selectByExample(userExample);
        if (CollectionUtils.isEmpty(userList)) {
            return null;
        } else {
            return userList.get(0);
        }

    }

  /*  public void resetPassword(UserResetPasswordReq req) {
        User user = CopyUtil.copy(req, User.class);
        userMapper.updateByPrimaryKeySelective(user);
    }*/


    public AdmintorLoginResp login(AdmintorLoginReq req) {

        Admintor admintor = selectByLoginName(req.getadmin());
        if (ObjectUtils.isEmpty(admintor)) {
            //用户不存在
            throw new BusinessException(BusinessExceptionCode.LOGIN_ADMIN_ERROR);
        } else {
            if (admintor.getPassword().equals(req.getPassword())) {
                //登录成功
                AdmintorLoginResp admintorLoginResp = CopyUtil.copy(admintor, AdmintorLoginResp.class);
                return admintorLoginResp ;
            } else {
                //密码不正确
                throw new BusinessException(BusinessExceptionCode.LOGIN_ADMIN_ERROR);
            }

        }
    }
}

