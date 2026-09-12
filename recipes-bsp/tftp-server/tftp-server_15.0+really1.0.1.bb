inherit qprebuilt pkgconfig systemd

LICENSE          = "LICENSE.qcom-2"
LIC_FILES_CHKSUM = "file://${QCOM_COMMON_LICENSE_DIR}${LICENSE};md5=165287851294f2fb8ac8cbc5e24b02b0"

DESCRIPTION = "tftp_server server module"

DEPENDS += "glib-2.0 virtual/kernel qmi-framework property-vault libcap"

PBT_ARCH = "armv8-2a"

ARMV8_SHA256SUM = "da02567a0533ee6062024b0f572ee9479455ec932349c3b5dfc0a792330fe39f"
SRC_URI[armv8-2a.sha256sum] = "${ARMV8_SHA256SUM}"

SRC_URI = "${PBT_ARTIFACTORY}/${PBT_BUILD_ID}/${PBT_BIN_PATH}/${BPN}_${PV}_${PBT_ARCH}.tar.gz;name=${PBT_ARCH}"

FILES:${PN} += "/system /data"
FILES:${PN} += "/lib/systemd/*"


SYSTEMD_SERVICE:${PN} = "tftp_server.service"
