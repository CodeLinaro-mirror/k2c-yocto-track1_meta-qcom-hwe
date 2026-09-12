inherit qprebuilt pkgconfig systemd

LICENSE          = "LICENSE.qcom-2"
LIC_FILES_CHKSUM = "file://${QCOM_COMMON_LICENSE_DIR}${LICENSE};md5=165287851294f2fb8ac8cbc5e24b02b0"

DESCRIPTION = "Time Services Daemon"

DEPENDS += "virtual/kernel glib-2.0 diag qmi-framework"

RDEPENDS:${PN} += "qmi-framework"

QCM6490_SHA256SUM = "9cc26fc0dd28404b6bbc084ab657b4e8f4a38e5bb91b0eac788b403909f73e34"
QCS9100_SHA256SUM = "d5fe732acd7d1855de8080ef3dc868251fc4148838dc738d02c4fe49abf141ce"
QCS8300_SHA256SUM = "ddeba13737d2dec3a699148cbc3bb19db5d504cc095778a18f60fdf908d7708a"
QCS615_SHA256SUM = "a9ea27e847fbb40cdef901abe72481f875364992618252f9c313ed0843058deb"

SRC_URI[qcm6490.sha256sum] = "${QCM6490_SHA256SUM}"
SRC_URI[qcs9100.sha256sum] = "${QCS9100_SHA256SUM}"
SRC_URI[qcs8300.sha256sum] = "${QCS8300_SHA256SUM}"
SRC_URI[qcs615.sha256sum] = "${QCS615_SHA256SUM}"

SRC_URI = "${PBT_ARTIFACTORY}/${PBT_BUILD_ID}/${PBT_BIN_PATH}/${BPN}_${PV}_${PBT_ARCH}.tar.gz;name=${PBT_ARCH}"

FILES:${PN} += "${sysconfdir}/system/*"
FILES:${PN} += "${sysconfdir}/udev/rules.d/time-services.rules"

