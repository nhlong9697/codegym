const posts = [
  { title: "Post One", body: "This is blog post one" },
  { title: "Post Two", body: "this is blog post two" },
];

function getPosts() {
  setTimeout(() => {
    let output = "";
    posts.forEach((post, index) => {
      output += `<li>${post.title}</li>`;
    });
    document.body.innerHTML = output;
  }, 1000);
}

function createPosts(post) {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      posts.push(post);
      const error = false;
      if (!error) {
        resolve();
      } else {
        reject("Error: Something went wrong");
      }
    }, 2000);
  });
}

/*createPosts({ title: "Post Three", body: "this is blog post three" })*/
//.then(getPosts())
/*.catch((err) => console.log(err));*/

//Promise.all
const promise1 = Promise.resolve("Hello world");
const promise2 = 10;
const promise3 = new Promise((resolve, reject) =>
  setTimeout(resolve, 2000, "GoodBye")
);
const promise4 = fetch(
  "https://jsonplaceholder.typicode.com/users"
).then((res) => res.json());
//takes the time of the longest promise to print console log
Promise.all([promise1, promise2, promise3, promise4]).then((values) =>
  console.log(values)
);
