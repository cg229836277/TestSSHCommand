因为这个文件在android下面可以跑起来，而且是22端口，上一个文件夹下面的
dropbear是2223端口，有问题，所以改成了这个文件在android下面登陆
dropbear -d /data/dropbear/dss_host_key -F -E -s -v

http://www.cnblogs.com/whltingyu/p/4083448.html