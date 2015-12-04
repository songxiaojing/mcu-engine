package com.topsec.bdc.mcu.engine.test.hdfs;

import java.io.IOException;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.topsec.bdc.mcu.engine.test.conf.ConfUtils;


public class HdfsUtils {

    /**
     * 日志.
     */
    private static final Logger logger = LoggerFactory.getLogger(HdfsUtils.class);

    // 

    public HdfsUtils(Configuration conf) {

        this(ConfUtils.fsDefaultName, conf);
    }

    public HdfsUtils(String hdfs, Configuration conf) {

        this.hdfsPath = hdfs;
        this.conf = conf;
    }

    private String hdfsPath;
    private Configuration conf;

    public static HdfsUtils getInstance() {

        Configuration conf = ConfUtils.getLocalConfiguration();
        HdfsUtils hdfs = new HdfsUtils(conf);
        return hdfs;
    }
    
    public void delete(String ... args) throws Exception {
    	for(int i=0; i<args.length; i++) {
    		HdfsUtils.getInstance().rmr(args[i]);
    	}
    	logger.info(" >>> delete hdfs path : " + args);
    }

    public static void main(String[] args) throws Exception {

        //JobConf conf = config();
        Configuration conf = new Configuration();
        HdfsUtils hdfs = new HdfsUtils(conf);
        //hdfs.ls("/");
        //hdfs.mkdirs("/javahdfs1");
        //hdfs.rmr("/javahdfs1");
        //hdfs.copyFile("E://wc.txt", "/wc");
        //hdfs.cat(new Path("/input/test1.txt"));
       // hdfs.deleteAllFile();
        hdfs.delete("2","e");
    }

    /**
     * hadoop mr init.
     * 
     * @throws Exception
     */
    public static void hadoopMrInit() throws Exception {

        Configuration conf = new Configuration();
        HdfsUtils hdfsUtils = new HdfsUtils(conf);

        hdfsUtils.deleteAllFile();
        hdfsUtils.createDefaulFile();

    }

    /**
     * delete all root file.
     * 
     * @param folder
     * @throws Exception
     */
    private void deleteAllFile() throws Exception {

        Path path = new Path("/");
        FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
        FileStatus[] list = fs.listStatus(path);
        for (FileStatus file : list) {
            fs.deleteOnExit(file.getPath());
        }
        fs.close();
    }

    /**
     * create default MR test file.
     * 
     * @throws IOException
     */
    private void createDefaulFile() throws IOException {

        String content = "hello word hello jetty hello tom";
        String dstFile = ConfUtils.fsDefaultName + "test";

        Configuration conf = new Configuration();
        Path dst = new Path(dstFile);
        FileSystem hdfs = null;
        FSDataOutputStream out = null;
        try {
            hdfs = dst.getFileSystem(conf);
            out = hdfs.create(dst);
            out.writeBytes(content);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException(e);
        } finally {
            if (hdfs != null) {
                hdfs.close();
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    /**
     * 
     * 
     * @param folder
     * @throws IOException
     */
    public void ls(String folder) throws IOException {

        Path path = new Path(folder);
        FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
        FileStatus[] list = fs.listStatus(path);
        logger.info("==========================================================");
        for (FileStatus f : list) {
            logger.info(f.getPath() + "/" + f.getLen());
            cat(f.getPath());
        }
        logger.info("==========================================================");
        fs.close();
    }

    /**
     * 
     * 
     * @param floaderName
     * @throws IOException
     */
    public void mkdirs(String floaderName) throws IOException {

        Path path = new Path(floaderName);
        FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
        if (!fs.exists(path)) {
            fs.mkdirs(path);
        }
        fs.close();
    }

    /**
     * 
     * 
     * @param floaderName
     * @throws IOException
     */
    public void rmr(Path path) throws IOException {

        FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
        fs.deleteOnExit(path);
        fs.close();
    }
    
    /**
     * 
     * @param path
     * @throws IOException
     */
    public void rmr(String path) throws IOException {
    	if(null != path && "".equals(path) == false) {
    		rmr(new Path(path));
    	}
    }

    /**
     * 
     * 
     * 
     * @param local
     * @param remote
     * @throws IOException
     */
    public void copyFile(String local, String remote) throws IOException {

        FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
        fs.copyFromLocalFile(new Path(local), new Path(remote));
        fs.close();
    }

    /**
     * 
     * HDFS 查看文件.
     * 
     * @param remoteFile
     * @throws IOException
     */
    public void cat(Path path) throws IOException {

        FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
        FSDataInputStream fsdis = null;
        try {
            fsdis = fs.open(path);
            IOUtils.copyBytes(fsdis, System.out, 4096, false);
        } finally {
            IOUtils.closeStream(fsdis);
            fs.close();
        }
    }

    /**
     * 
     * 
     * @param remote
     * @param local
     * @throws IOException
     */
    public void download(String remote, String local) throws IOException {

        Path path = new Path(remote);
        FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
        fs.copyToLocalFile(path, new Path(local));
        fs.close();
    }

}