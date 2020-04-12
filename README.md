# server_monolithic

《服务端开发》 Server-side Programming Assignment



## 简介


URL : http://localhost:8088/section1


<img width="1041" alt="pic1" src="https://user-images.githubusercontent.com/44460142/79064218-f948b900-7ce1-11ea-8a56-6d305b3b208f.png">

## 工作量

1、清空web.xml配置，改成java配置类 

<img width="166" alt="peizhi" src="https://user-images.githubusercontent.com/44460142/79064219-fa79e600-7ce1-11ea-917d-cbc840e9ecef.png">


2、优化控制层的loginCheck方法，并且添加数据校验功能(@Valid)，用户名3-6个字符，口令6个字符，并有错误提示 

<img width="631" alt="yanzheng" src="https://user-images.githubusercontent.com/44460142/79064216-f4840500-7ce1-11ea-9a5a-4721b43bb3a9.png">

3、改成H2内嵌数据库

4、DAO层实现改成JpaRepository自动实现

5、DAO层的findUserByUserName添加缓存功能，缓存用EhCache实现 

6、测试改进:service层的测试将现在直连数据库改成使用mock取代dao层 
