inherit cmake pkgconfig qprebuilt

LICENSE          = "LICENSE.qcom-2"
LIC_FILES_CHKSUM = "file://${QCOM_COMMON_LICENSE_DIR}${LICENSE};md5=165287851294f2fb8ac8cbc5e24b02b0"

DESCRIPTION = "Chicdk Autogen"

DEPENDS:qcom-custom-bsp += "camxapi camxcommon protobuf-native protobuf"

QCS9100_SHA256SUM = "76239554b1de8a6c244cb1d5008e96180ae9db07a0dcd1040ac49c687652836c"
QCS8300_SHA256SUM = "891418ab417751857362da4f18a251883752cc697f1c731e7a8fdaf0eddae725"
QCS615_SHA256SUM = "c637ad64333ec797a1c78b093ea43bba7fa0e75bac496c862ec1cc77a4fc37b0"

SRC_URI[qcs9100.sha256sum] = "${QCS9100_SHA256SUM}"
SRC_URI[qcs8300.sha256sum] = "${QCS8300_SHA256SUM}"
SRC_URI[qcs615.sha256sum] = "${QCS615_SHA256SUM}"

SRC_URI = "${PBT_ARTIFACTORY}/${PBT_BUILD_ID}/${PBT_BIN_PATH}/${BPN}_${PV}_${PBT_ARCH}.tar.gz;name=${PBT_ARCH}"

do_package_qa[noexec] = "1"

FILES:${PN} = "\
    /usr/lib/* \
    /usr/bin/* \
    /lib/firmware/*"

FILES:${PN}-dev = "/usr/include/*"
INSANE_SKIP = "1"
#Skips check for .so symlinks
INSANE_SKIP:${PN} = "dev-so"
