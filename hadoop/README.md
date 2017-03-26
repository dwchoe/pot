# hadoop_sandbox

## Install Hadoop on the Mac
#### Install HomeBrew
```
$ ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
```

#### Install hadoop
```
$ brew install hadoop
```
Hadoop will be installed in the following directory <br>
/usr/local/Cellar/hadoop

#### Configuring Hadoop
##### Edit hadoop-env.sh

The file can be located at /usr/local/Cellar/hadoop/2.7.1/libexec/etc/hadoop/hadoop-env.sh <br>
where 2.7.1is the hadoop version.

Find the line with <br>
```
export HADOOP_OPTS="$HADOOP_OPTS -Djava.net.preferIPv4Stack=true"
```
and change it to
```
export HADOOP_OPTS="$HADOOP_OPTS -Djava.net.preferIPv4Stack=true -Djava.security.krb5.realm= -Djava.security.krb5.kdc="
```
##### Edit Core-site.xml
The file can be located at /usr/local/Cellar/hadoop/2.6.0/libexec/etc/hadoop/core-site.xml .
```
  <property>
     <name>hadoop.tmp.dir</name>
     <value>/usr/local/Cellar/hadoop/hdfs/tmp</value>
     <description>A base for other temporary directories.</description>
  </property>
  <property>
     <name>fs.default.name</name>                                     
     <value>hdfs://localhost:9000</value>                             
  </property>   
  ```
##### Edit mapred-site.xml
The file can be located at /usr/local/Cellar/hadoop/2.6.0/libexec/etc/hadoop/mapred-site.xml and by default will be blank.
```
<configuration>
<property>
<name>mapred.job.tracker</name>
<value>localhost:9010</value>
</property>
</configuration>
```
##### Edit hdfs-site.xml
The file can be located at /usr/local/Cellar/hadoop/2.6.0/libexec/etc/hadoop/hdfs-site.xml .
```
<configuration>
<property>
<name>dfs.replication</name>
<value>1</value>
</property>
</configuration>
```
To simplify life edit your ~/.profile using vim or your favorite editor and add the following two commands. By default ~/.profile might not exist.
```
alias hstart="/usr/local/Cellar/hadoop/2.6.0/sbin/start-dfs.sh;/usr/local/Cellar/hadoop/2.6.0/sbin/start-yarn.sh"
alias hstop="/usr/local/Cellar/hadoop/2.6.0/sbin/stop-yarn.sh;/usr/local/Cellar/hadoop/2.6.0/sbin/stop-dfs.sh"
```
and execute
```
$ source ~/.profile
```
in the terminal to update.

Before we can run Hadoop we first need to format the HDFS using
```
$ hdfs namenode -format
```
##### SSH Localhost
Nothing needs to be done here if you have already generated ssh keys. To verify just check for the existance of ~/.ssh/id_rsa and the ~/.ssh/id_rsa.pub files. If not the keys can be generated using
```
$ ssh-keygen -t rsa
```
Enable Remote Login <br>
“System Preferences” -> “Sharing”. Check “Remote Login” <br>
Authorize SSH Keys <br>
To allow your system to accept login, we have to make it aware of the keys that will be used

```
$ cat ~/.ssh/id_rsa.pub >> ~/.ssh/authorized_keys
```
Let’s try to login.
```
$ ssh localhost
Last login: Fri Mar  6 20:30:53 2015
$ exit
```
##### Running Hadoop
Now we can run Hadoop just by typing
```
$ hstart
```
or
```
$ bin/start-all.sh
```

and stopping using
```
$ hstop
```
##### Download Examples
To run examples, Hadoop needs to be started.

Hadoop Examples 1.2.1 (Old) <br>
Hadoop Examples 2.6.0 (Current) <br>

Test them out using:
```
$ hadoop jar  pi 10 100
```
##### Good to know
We can access the Hadoop web interface by connecting to
```
Resource Manager: http://localhost:50070
JobTracker: http://localhost:8088
Specific Node Information: http://localhost:8042

Command
$ jps 
7379 DataNode
7459 SecondaryNameNode
7316 NameNode
7636 NodeManager
7562 ResourceManager
7676 Jps

$ yarn  // For resource management more information than the web interface. 
$ mapred  // Detailed information about jobs
```

---
reference
* http://amodernstory.com/2014/09/23/installing-hadoop-on-mac-osx-yosemite/
* http://magpiehall.com/how-to-install-hadoop-on-mac-os-x/
* http://shayanmasood.com/blog/how-to-setup-hadoop-on-mac-os-x-10-9-mavericks/


tutorial
* http://hadoop.apache.org/docs/r1.2.1/mapred_tutorial.html
