inherit qprebuilt pkgconfig

LICENSE          = "LICENSE.qcom-2"
LIC_FILES_CHKSUM = "file://${QCOM_COMMON_LICENSE_DIR}/${LICENSE};md5=165287851294f2fb8ac8cbc5e24b02b0"

DESCRIPTION = "Securemsm library with sampleclient used to test sampleapp with qseecom driver through QSEEComApi library"

DEPENDS += "minkipc securemsm-features glib-2.0 glibc linux-kernel-qcom-headers qcom-libdmabufheap"

QCM6490_SHA256SUM = "c450a061484ea512c5188ee812c3537b37a85c5d794a4bcf59df68a180e25c72"
QCS9100_SHA256SUM = "881cb2674d00f5ba189ea44ecd5d97f3f2b8092f2e0cc139bc89901f9443a8aa"
QCS8300_SHA256SUM = "24d022be1a811fb9ab367fa83c96aa0004a732176135fa1bd05dd679fc96cc60"
QCS615_SHA256SUM = "13ec97dc61b7eb94148594caba8c009e463d33c366e2333a0a2bda85c73ebf80"

SRC_URI[qcm6490.sha256sum] = "${QCM6490_SHA256SUM}"
SRC_URI[qcs9100.sha256sum] = "${QCS9100_SHA256SUM}"
SRC_URI[qcs8300.sha256sum] = "${QCS8300_SHA256SUM}"
SRC_URI[qcs615.sha256sum] = "${QCS615_SHA256SUM}"

SRC_URI = "${PBT_ARTIFACTORY}/${PBT_BUILD_ID}/${PBT_BIN_PATH}/${BPN}_${PV}_${PBT_ARCH}.tar.gz;name=${PBT_ARCH}"

FILES:${PN} += "/usr/bin/*"
FILES:${PN} += "${bindir}/* /var/local/*"

INSANE_SKIP:${PN} += "debug-files"

