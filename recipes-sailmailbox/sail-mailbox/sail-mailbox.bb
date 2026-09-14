inherit autotools-brokensep pkgconfig qprebuilt systemd

SUMMARY = "Driver providing support for SAIL-APSS Mailbox communication"
DESCRIPTION = "Provide Sail Mailbox Driver to communicate between SAIL and APSS"
LICENSE = "LICENSE.qcom-2"
LIC_FILES_CHKSUM = "file://${QCOM_COMMON_LICENSE_DIR}/${LICENSE};md5=165287851294f2fb8ac8cbc5e24b02b0"
DEPENDS += "glib-2.0 systemd linux-libc-headers pkgconfig-native cmake-native"

QCS9100_SHA256SUM = "d528cbd9b5f1fb55cbfefa8ea1d9fe036cf0a4fc02bc90c1bfcbd5905827735f"

SRC_URI[qcs9100.sha256sum] = "${QCS9100_SHA256SUM}"

SRC_URI:append:qcs9100  = "${PBT_ARTIFACTORY}/${PBT_BUILD_ID}/${PBT_BIN_PATH}/${BPN}_${PV}_${PBT_ARCH}.tar.gz;name=${PBT_ARCH}"



QCS8300_SHA256SUM = "8909ea31c6cf2aa6284ecde185292f755af7f921910255300e14c815bf5aa91d"

SRC_URI[qcs8300.sha256sum] = "${QCS8300_SHA256SUM}"

SRC_URI:append:qcs8300  = "${PBT_ARTIFACTORY}/${PBT_BUILD_ID}/${PBT_BIN_PATH}/${BPN}_${PV}_${PBT_ARCH}.tar.gz;name=${PBT_ARCH}"

PACKAGES =+ "${PN}-bin"

do_install:append(){
}

SOLIBS = ".so"
FILES_SOLIBSDEV = ""

FILES:${PN}-bin = "image/${bindir}/sail_console_chan_app"
FILES:${PN}-bin = "image/${bindir}/saildbg"

