var workflow = {
	"version" : "1.0.0",
	"driver" : {
		"name" : "spark",
		"version" : "1.5.1"
	},
	"inResource" : [ {
		"type" : "FileInResouce",
		"resource" : [ "/home/baiyanwei/test/" ]
	} ],
	"outResource" : [ {
		"type" : "HDFSOutput",
		"resource" : [ "/baiyanwei/staging/test/" ]
	} ],

}