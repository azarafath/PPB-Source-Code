package id.my.zakariafathoni.profiledoseninformatika

object DataDosen {
    private val dosenImages = intArrayOf(
        R.drawable.kamto,
        R.drawable.kurnianingsih,
        R.drawable.parsumo,
        R.drawable.mardi,
        R.drawable.yudan,
        R.drawable.handoko,
        R.drawable.idha,
        R.drawable.liliek,
        R.drawable.irwan,
        R.drawable.afandi
    )

    private val dosenNames = arrayOf(
        "Sukamto, S.Kom., M.T",
        "Dr. Kurnianingsih, M.T",
        "Drs. Parsumo Raharjo, M.Kom",
        "Mardiyono, S.Kom., M.Sc",
        "T R Yudantoro, M.Kom",
        "Slamet Handoko, M.Kom ",
        "Idhawati Hestiningsih, M.Kom",
        "Liliek Triyono, S.T., M.Kom",
        "M Irwan Yanwari, S.Kom., M.Eng",
        "Afandi Nur Aziz Thohari, S.T., M.Cs"
    )

    private val dosenNIP = arrayOf(
        "197101172003121001",
        "197904262003122002",
        "196008221988031001",
        "197403112000121001",
        "196810252000121001",
        "197501302001121001",
        "197711192008012013",
        "198404202015041003",
        "199001072019031020",
        "199004112019031014"
    )

    private val dosenKeahlian = arrayOf(
        "Mobile development, dan Database programming",
        "Kecerdasan buatan, Pembelajaran Mesin, dan Visi Komputer",
        "Jaringan Komputer, dan Virtualisasi",
        "Kecerdasan Buatan, dan Internet of Things",
        "Rekayasa Perangkat Lunak, dan Jaringan komputer",
        "Database Programming, dan Visualisasi Data",
        "Pemrograman Berorientasi Objek, dan Mobile Development",
        "Kecerdasan Buatan, dan Mobile Development",
        "Web Development, dan Desain Grafis",
        "Mobile Programming, Kecerdasan Buatan, dan Data Science"
    )

    val listData: ArrayList<Dosen>
        get() {
            val list = arrayListOf<Dosen>()
            for (position in dosenNames.indices){
                val dosen = Dosen()
                dosen.name = dosenNames[position]
                dosen.photo = dosenImages[position]
                dosen.nip = dosenNIP[position]
                dosen.keahlian = dosenKeahlian[position]
                list.add(dosen)
            }
            return list
        }
}