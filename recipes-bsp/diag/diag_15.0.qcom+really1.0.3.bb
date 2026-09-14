inherit qprebuilt pkgconfig systemd

LICENSE          = "LICENSE.qcom-2"
LIC_FILES_CHKSUM = "file://${QCOM_COMMON_LICENSE_DIR}${LICENSE};md5=165287851294f2fb8ac8cbc5e24b02b0"

DESCRIPTION = "Library and routing applications for diagnostic traffic"

DEPENDS += "glib-2.0 time-genoff"

QCM6490_SHA256SUM = "0d46bc779f637cb41b27d29e12c4c1086d41b65146d5d9c3a5b80be69e5fed94"
QCS9100_SHA256SUM = "e7c076c2ff59cbe0e46c91fbbc33b85a38134622daa389faca19474bda06fe62"
QCS8300_SHA256SUM = "23b5402b0ff696782c070d6e475e8d47bd33cab78c4a3b8ade19cc75fcad003e"
QCS615_SHA256SUM = "095e5813a6a27e6b9889c0ad7fcea80091f92f9938ce6cb196a80bf1507f6412"

SRC_URI[qcm6490.sha256sum] = "${QCM6490_SHA256SUM}"
SRC_URI[qcs9100.sha256sum] = "${QCS9100_SHA256SUM}"
SRC_URI[qcs8300.sha256sum] = "${QCS8300_SHA256SUM}"
SRC_URI[qcs615.sha256sum] = "${QCS615_SHA256SUM}"

SRC_URI = "${PBT_ARTIFACTORY}/${PBT_BUILD_ID}/${PBT_BIN_PATH}/${BPN}_${PV}_${PBT_ARCH}.tar.gz;name=${PBT_ARCH}"

FILES:${PN} += "${systemd_unitdir}/system/"

