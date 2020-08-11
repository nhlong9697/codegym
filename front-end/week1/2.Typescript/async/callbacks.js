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

function createPosts(post, callback) {
  setTimeout(() => {
    posts.push(post);
    callback();
  }, 2000);
}

createPosts({ title: "Post Three", body: "this is blog post three" }, getPosts);
