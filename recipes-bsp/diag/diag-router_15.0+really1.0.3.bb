inherit qprebuilt pkgconfig systemd

LICENSE          = "LICENSE.qcom-2"
LIC_FILES_CHKSUM = "file://${QCOM_COMMON_LICENSE_DIR}${LICENSE};md5=165287851294f2fb8ac8cbc5e24b02b0"

DESCRIPTION = "Library and routing applications for diagnostic traffic"

DEPENDS += "syslog-plumber glib-2.0 qmi-framework diag"

QCM6490_SHA256SUM = "75efa66d4ef598fd08a69a206867277a9825dec5517c1c638e7f2c73b78d6622"
QCS9100_SHA256SUM = "b8a4cf01bb66d3d7ca111e60f19ef73362c1a61798cfe750f97aeec588489279"
QCS8300_SHA256SUM = "8e4d7ad1d3e9e15656587e9550662d050df631b3d486779aa1d01513e8c8edd4"
QCS615_SHA256SUM = "8a349fd3ca5111ff7246503bb469ebedd3bfc9d134b51ac019ca7ccd3c9af19b"

SRC_URI[qcm6490.sha256sum] = "${QCM6490_SHA256SUM}"
SRC_URI[qcs9100.sha256sum] = "${QCS9100_SHA256SUM}"
SRC_URI[qcs8300.sha256sum] = "${QCS8300_SHA256SUM}"
SRC_URI[qcs615.sha256sum] = "${QCS615_SHA256SUM}"

SRC_URI = "${PBT_ARTIFACTORY}/${PBT_BUILD_ID}/${PBT_BIN_PATH}/${BPN}_${PV}_${PBT_ARCH}.tar.gz;name=${PBT_ARCH}"

FILES:${PN} += "${systemd_unitdir}/system/"

