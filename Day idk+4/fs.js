import fs from 'fs';

const filePath = 'data.txt';
if (fs.existsSync(filePath)) {
  console.log('File exists.\n');

  const data = fs.readFileSync(filePath,'utf8');
  console.log(`File Content: ${data}`);

  const lines = data.split('\n');
  console.log('\nLines Array:');
  console.log(lines);

  fs.appendFileSync(filePath, '\nNew line added');
  console.log('\nData appended successfully.');

} else {
  console.log('File does not exist');

  fs.writeFileSync(
    filePath,
    'Hello Rui!\n Hello World!'
  );

  console.log('File created successfully');
}

console.log('\nDirectory Contents:');
const files = fs.readdirSync('.');
files.forEach(file => console.log(file));