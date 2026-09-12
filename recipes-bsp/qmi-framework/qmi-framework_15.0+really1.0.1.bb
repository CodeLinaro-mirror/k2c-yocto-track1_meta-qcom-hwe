inherit qprebuilt pkgconfig systemd

LICENSE          = "LICENSE.qcom-2"
LIC_FILES_CHKSUM = "file://${QCOM_COMMON_LICENSE_DIR}${LICENSE};md5=165287851294f2fb8ac8cbc5e24b02b0"

DESCRIPTION = "QMI framework will provide sample applications to test QMI communication between Apps and other remote sub systems. It also includes multiple services to support the QMI communications. qrtr-ns service should be running in background to support QMI communication because qrtr-ns is the one which handles the qrtr control packet. qrtr-filter service is required if the target want QMI access control which avoids unprivileged access to QMI services"

DEPENDS += "glib-2.0 property-vault syslog-plumber qrtr"

QCM6490_SHA256SUM = "8b6bd4e09e1016e2ea9debee94792cbedd7e923887a0f5c76f01db50a487c5ad"
QCS9100_SHA256SUM = "28d1665b5ec753c2dc6b3473792a0a01faebcdf81bbc19a2cb7967e0b75cca88"
QCS8300_SHA256SUM = "22753a271038d3f8cc83d72e6c99bd3b352cd96511a913b331cf262674c50dfa"
QCS615_SHA256SUM = "01ee8c3c0f28c25d4cd6f9d508cc1bab36b92e8ad11ef0be9ae23bfeebba7d9e"

SRC_URI[qcm6490.sha256sum] = "${QCM6490_SHA256SUM}"
SRC_URI[qcs9100.sha256sum] = "${QCS9100_SHA256SUM}"
SRC_URI[qcs8300.sha256sum] = "${QCS8300_SHA256SUM}"
SRC_URI[qcs615.sha256sum] = "${QCS615_SHA256SUM}"

SRC_URI = "${PBT_ARTIFACTORY}/${PBT_BUILD_ID}/${PBT_BIN_PATH}/${BPN}_${PV}_${PBT_ARCH}.tar.gz;name=${PBT_ARCH}"

FILES:${PN} += "${systemd_unitdir}/system/"

