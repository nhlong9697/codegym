let i = 10;
let f = 20.5
let b = true
let s = 'hà nội'

document.write('i = ' + i)
document.write('<br/>')
document.write('f = ' + f)
document.write('<br/>')
document.write('b = ' + b)
document.write('<br/>')
document.write('s = ' + s)
document.write('<br/>')

let width = 20
let height = 10
let area = width * height
document.write('Area = ' + area)

let soA = prompt("Nhap so a")
let soB = prompt("Nhap so b")

if (soA % soB == 0) {
  alert('a chia het cho b')
}
else {
  alert('a khong chia het cho b')
}
