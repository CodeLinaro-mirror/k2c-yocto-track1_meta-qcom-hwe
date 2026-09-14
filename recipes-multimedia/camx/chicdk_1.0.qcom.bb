inherit qprebuilt pkgconfig

LICENSE          = "LICENSE.qcom-2"
LIC_FILES_CHKSUM = "file://${QCOM_COMMON_LICENSE_DIR}${LICENSE};md5=165287851294f2fb8ac8cbc5e24b02b0"

DESCRIPTION = "Camx"

DEPENDS += "syslog-plumber glib-2.0 property-vault camx chicdk-autogen qcom-fastcv-binaries protobuf-native protobuf"

QCS9100_SHA256SUM = "2665d3cf825c5d3286b7198fcbb12aa791792c55270eab76d0115b2eeba8af49"
QCS8300_SHA256SUM = "d766261714126795b58a691940fb547b0fc5f9d81048b5ede94f80454f54b4d8"
QCS615_SHA256SUM = "6722da2680919585a36ef9ab4ffff7e2d091dc015c58643468ad3b92262a1c08"

SRC_URI[qcs9100.sha256sum] = "${QCS9100_SHA256SUM}"
SRC_URI[qcs8300.sha256sum] = "${QCS8300_SHA256SUM}"
SRC_URI[qcs615.sha256sum] = "${QCS615_SHA256SUM}"

SRC_URI = "${PBT_ARTIFACTORY}/${PBT_BUILD_ID}/${PBT_BIN_PATH}/${BPN}_${PV}_${PBT_ARCH}.tar.gz;name=${PBT_ARCH}"

FILES:${PN} = "\
    /usr/lib/* \
    /usr/bin/* \
    /usr/lib/rfsa/adsp/* \
    /system/etc/camera/*"
FILES:${PN}-dev = ""

#Skips check for .so symlinks
INSANE_SKIP:${PN} = "already-stripped"
#The modules require .so to be dynamicaly loaded
INSANE_SKIP:${PN} += "dev-so"
