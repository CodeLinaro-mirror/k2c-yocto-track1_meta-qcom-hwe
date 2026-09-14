inherit qprebuilt pkgconfig

LICENSE          = "LICENSE.qcom-2"
LIC_FILES_CHKSUM = "file://${QCOM_COMMON_LICENSE_DIR}${LICENSE};md5=165287851294f2fb8ac8cbc5e24b02b0"

DESCRIPTION = "Camx"

DEPENDS += "syslog-plumber glib-2.0 property-vault camxapi"

QCS9100_SHA256SUM = "a7fecb9edb0c01e0a255e7289a49f3054d6456ea70dc66d8fbf9d54732c75efc"
QCS8300_SHA256SUM = "2e2392d13dd46cd7ade2077e4434af598ab1420c3e5e6dc56df38f67a171addb"
QCS615_SHA256SUM = "be96b569a712ca527cde847b5022de77c28ebe6b97e380cabe262a86623a817d"

SRC_URI[qcs9100.sha256sum] = "${QCS9100_SHA256SUM}"
SRC_URI[qcs8300.sha256sum] = "${QCS8300_SHA256SUM}"
SRC_URI[qcs615.sha256sum] = "${QCS615_SHA256SUM}"

SRC_URI = "${PBT_ARTIFACTORY}/${PBT_BUILD_ID}/${PBT_BIN_PATH}/${BPN}_${PV}_${PBT_ARCH}.tar.gz;name=${PBT_ARCH}"

FILES:${PN}-dev = "/usr/include/*"
FILES:${PN} = "\
    /usr/lib/* \
    /usr/bin/* \
    /usr/include/* \
    /lib/firmware/*"

#Skips check for .so symlinks
INSANE_SKIP = "1"
INSANE_SKIP:${PN} = "dev-so"

