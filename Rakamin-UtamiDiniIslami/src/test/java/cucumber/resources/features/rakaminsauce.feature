Feature: Automated Testing Sauce Demo Website

  @Positive
  Scenario: Login ke Sauce Demo dengan valid kredensial
    Given User berada di halaman login Sauce Demo
    When User menginput username dan password yang valid
    And User klik tombol login
    Then User berhasil login dan dapat melihat katalog produk

  @Negative
  Scenario: Login ke Sauce Demo dengan invalid kredensial
    Given User berada di halaman login Sauce Demo
    When User menginput username dan password yang invalid
    And User klik tombol login
    Then User mendapatkan pesan error

  @Positive
  Scenario: Menambahkan produk ke keranjang
    Given User login ke website Sauce Demo
    When User menambahkan beberapa produk ke keranjang
    Then Keranjang user terdapat produk yang dipilih

  @Positive
  Scenario: Keluar dari Sauce Demo
    Given User login ke website Sauce Demo
    When User klik tombol logout
    Then User berhasil logout dan kembali ke halaman login