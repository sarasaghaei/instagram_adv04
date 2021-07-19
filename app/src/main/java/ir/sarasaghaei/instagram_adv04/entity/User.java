package ir.sarasaghaei.instagram_adv04.entity;

public class User {
    private String name, detail,detail_post;
    int id_user, id_post,fallow, like_post,pic_user,link_post1,link_post2,link_post3 ;

    public User(int id_user,String name, int pic_user, String detail) {
        this.id_user = id_user;
        this.name = name;
        this.pic_user = pic_user;
        this.detail = detail;

    }

    public User(int id_user, String name,int pic_user,
                String detail,int id_post,
                int link_post1, int link_post2, int link_post3,
                String detail_post,int fallow, int like_post) {
        this.name = name;
        this.detail = detail;
        this.detail_post = detail_post;
        this.id_user = id_user;
        this.id_post = id_post;
        this.fallow = fallow;
        this.like_post = like_post;
        this.pic_user = pic_user;
        this.link_post1 = link_post1;
        this.link_post2 = link_post2;
        this.link_post3 = link_post3;
    }


    public String getName() {
        return name;
    }

    public int getPic_user() {
        return pic_user;
    }

    public String getDetail() {
        return detail;
    }

    public int getLink_post1() {
        return link_post1;
    }

    public int getLink_post2() {
        return link_post2;
    }

    public int getLink_post3() {
        return link_post3;
    }

    public String getDetail_post() {
        return detail_post;
    }

    public int getId_user() {
        return id_user;
    }

    public int getId_post() {
        return id_post;
    }

    public int getFallow() {  return fallow;     }

    public int getLike_post() {  return like_post;     }

    public void setName(String name) {
        this.name = name;
    }

    public void setPic_user(int pic_user) {
        this.pic_user = pic_user;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setLink_post1(int link_post1) {
        this.link_post1 = link_post1;
    }

    public void setLink_post2(int link_post2) {
        this.link_post2 = link_post2;
    }

    public void setLink_post3(int link_post3) {
        this.link_post3 = link_post3;
    }

    public void setDetail_post(String detail_post) {
        this.detail_post = detail_post;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
    }

    public void setFallow(int fallow) {
        this.fallow = fallow;
    }

    public void setLike_post(int like_post) {
        this.like_post = like_post;
    }


}
