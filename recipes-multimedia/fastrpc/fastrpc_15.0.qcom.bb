inherit qprebuilt pkgconfig systemd

LICENSE          = "LICENSE.qcom-2"
LIC_FILES_CHKSUM = "file://${QCOM_COMMON_LICENSE_DIR}${LICENSE};md5=165287851294f2fb8ac8cbc5e24b02b0"
SUMMARY = "FastRPC user space libraries and daemons needed to offload to DSPs"

DEPENDS += "dspservices-headers qcom-libdmabufheap"

DEFAULT_PREFERENCE = "-1"

PBT_ARCH = "${SOC_ARCH}"

QCM6490_SHA256SUM = "d25b2c94eeb254a8e03d1fc4bb0a676e0cc19e0357c2edd702b8d85e4a97312f"
QCS9100_SHA256SUM = "464b641d7174d688dde227073081cce46c1c0f5a082c2a293e319c155c881db2"
QCS8300_SHA256SUM = "87ede80b1781549a6f018ae539729136f9c80e2cb46c98f687de510d93fa1129"
QCS615_SHA256SUM = "8f727c3b912708309c560042dfd90f608c548e11b11ed3d245a85548122cf6fc"

SRC_URI[qcm6490.sha256sum] = "${QCM6490_SHA256SUM}"
SRC_URI[qcs9100.sha256sum] = "${QCS9100_SHA256SUM}"
SRC_URI[qcs8300.sha256sum] = "${QCS8300_SHA256SUM}"
SRC_URI[qcs615.sha256sum] = "${QCS615_SHA256SUM}"

SRC_URI = "${PBT_ARTIFACTORY}/${PBT_BUILD_ID}/${PBT_BIN_PATH}/${BPN}_${PV}_${PBT_ARCH}.tar.gz;name=${PBT_ARCH}"

# Install systemd unit file at right location
relocate_systemd_unit_files () {
    if [ -d "${D}/lib/systemd" ]; then
        install -d ${D}/usr/lib/
        mv ${D}/lib/systemd  ${D}/usr/lib/systemd
    fi
}
do_install[postfuncs] += "relocate_systemd_unit_files"

FILES:${PN} += "${libdir}/*.so ${libdir}/pkgconfig/ ${systemd_unitdir}/system/* ${sysconfdir}/* ${bindir}/*"
FILES:${PN}-dev = "${libdir}/*.la ${includedir}"

PACKAGE_ARCH    ?= "${SOC_ARCH}"

INSANE_SKIP:${PN} += "already-stripped"
INSANE_SKIP:${PN} += "installed-vs-shipped"
INSANE_SKIP:${PN} += "dev-so"

SYSTEMD_SERVICE:${PN}:append = " adsprpcd.service cdsprpcd.service cdsp1rpcd.service gdsprpcd.service gdsp1rpcd.service"
SYSTEMD_AUTO_ENABLE:${PN} = "disable"
