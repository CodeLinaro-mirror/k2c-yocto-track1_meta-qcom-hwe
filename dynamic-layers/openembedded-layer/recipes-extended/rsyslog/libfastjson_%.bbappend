#Switch to use main branch instead of master
SRC_URI:remove = "git://github.com/rsyslog/libfastjson.git;protocol=https;branch=master"
SRC_URI:append = " git://github.com/rsyslog/libfastjson.git;protocol=https;branch=main"
