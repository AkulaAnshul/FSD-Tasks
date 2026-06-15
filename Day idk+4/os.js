import os from 'os';

console.log('Platform:',os.platform());
console.log('Hostname:',os.hostname());
console.log('Architecture:',os.arch());
console.log('CPU Cores:',os.cpus().length);
console.log('Free Memory:',os.freemem());
console.log('Total Memory:',os.totalmem());