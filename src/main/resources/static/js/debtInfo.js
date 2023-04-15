function toggleRow(row) {
    var content = row.nextElementSibling;
    if (content.style.display === "none") {
        content.style.display = "table-row";
    } else {
        content.style.display = "none";
    }
}