inherit qprebuilt pkgconfig

LICENSE          = "LICENSE.qcom-2"
LIC_FILES_CHKSUM = "file://${QCOM_COMMON_LICENSE_DIR}/${LICENSE};md5=165287851294f2fb8ac8cbc5e24b02b0"

DESCRIPTION = "Libraries enabling MinkIPC"

DEPENDS += "glib-2.0 glibc linux-kernel-qcom-headers qcom-libdmabufheap securemsm-headers"

QCM6490_SHA256SUM = "b7c5d642045aeebff25c4c4ee016fc91cdbb438ad20187ca0f1d3debd8c68926"
QCS9100_SHA256SUM = "1c4431bc8a08fa18d1b1c8f4f2c676a2aa46ae1a3f0cfa4614499ae93f2e5c1e"
QCS8300_SHA256SUM = "75994d8a902597bd35bb0c450f1603b97253e13b280fdbee4701f91a5a704343"
QCS615_SHA256SUM = "95c77c9278fec9fe8ddf7a5fee9e6294baea86a54ced4c1a99ebb029a81b7854"

SRC_URI[qcm6490.sha256sum] = "${QCM6490_SHA256SUM}"
SRC_URI[qcs9100.sha256sum] = "${QCS9100_SHA256SUM}"
SRC_URI[qcs8300.sha256sum] = "${QCS8300_SHA256SUM}"
SRC_URI[qcs615.sha256sum] = "${QCS615_SHA256SUM}"

SRC_URI = "${PBT_ARTIFACTORY}/${PBT_BUILD_ID}/${PBT_BIN_PATH}/${BPN}_${PV}_${PBT_ARCH}.tar.gz;name=${PBT_ARCH}"

FILES:${PN} += "/usr/bin/*"
FILES:${PN} += "${bindir}/*"
FILES:${PN} += "${libdir} ${includedir}"
FILES:${PN}-dev = "${libdir}/*.la"


INSANE_SKIP:${PN} = "dev-so"
INSANE_SKIP:${PN} += "debug-files"

