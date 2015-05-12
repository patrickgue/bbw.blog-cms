/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbw.cms.bean;

import ch.bbw.cms.database.DatabaseControl;
import ch.bbw.cms.inf.DatabaseControlInf;
import ch.bbw.cms.inf.Log;
import ch.bbw.cms.mock.DatabaseControlMock;
import ch.bbw.cms.mock.DefaultLog;
import ch.bbw.cms.models.Post;
import java.util.ArrayList;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;


/**
 *
 * @author patrick
 */
@ManagedBean
@SessionScoped
public class IndexBean {

    private DatabaseControlInf database;
    private ArrayList<Post> postList;// = new ArrayList<Post>();
    private String cssFile = "main.css";
    private String search = "Search";
    private Post currentPost;
    private Log log = new DefaultLog();
    private FacesContext context;
    

    
    public IndexBean() {
        context = FacesContext.getCurrentInstance();
        
        database = new DatabaseControl();
        if(postList == null){
            postList = database.getPosts();
        }
        try{
	    currentPost = postList.get(0);
	} catch(IndexOutOfBoundsException ex){
	    currentPost = new Post(-1, "Ask the admin to get a creator account to publish your own blog!",  "no Posts");
	}

	log.debug("PostList: "+postList);
        
    }
    
    public ArrayList<Post> getPostList(){ 
        if(search.equals("") || search.equals("Search")){
            refreshPostList();
        }
        return postList;
    }
    
    public void setPostList(ArrayList<Post> postList){
        this.postList = postList;
    }
    
    public void refreshPostList(){
        log.debug("Refresh");
        postList = database.getPosts();
    }
    
    public static void main(String[] args){
        IndexBean testBean = new IndexBean();
        
        for(Post p : testBean.getPostList()){
            System.out.println(p.getTitle()+"\n"+p.getContent());
        }
    }

    /**
     * @return the cssFile
     */
    public String getCssFile() {
        return cssFile;
    }

    /**
     * @param cssFile the cssFile to set
     */
    public void setCssFile(String cssFile) {
        this.cssFile = cssFile;
    }
    
    public String switchStyles(){
        if("main.css".equals(cssFile)){
            cssFile = "main_alt.css";
        } else {
            cssFile = "main.css";
        }
        return "main.xhtml";
    }

    /**
     * @return the search
     */
    public String getSearch() {
        return search;
    }

    /**
     * @param search the search to set
     */
    public void setSearch(String search) {
        this.search = search;
    }

    public String performSearch(){
        setPostList(database.getPosts(search));
        log.debug(search+", "+postList.toString());
        return "main.xhtml";
    }
    
    /**
     * @return the currentPost
     */
    public Post getCurrentPost() {
        return currentPost;
    }

    /**
     * @param currentPost the currentPost to set
     */
    public void setCurrentPost(Post currentPost) {
        this.currentPost = currentPost;
    }

  
}