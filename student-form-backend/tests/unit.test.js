// Example unit test for validating email format
function isValidEmail(email) {
  return /^[a-zA-Z0-9._%+-]+@}$/.test(email);
}

test("Valid email should pass", () => {
  expect(isValidEmail("spandana@gmail.com")).toBe(true);
});

test("Invalid email should fail", () => {
  expect(isValidEmail("spandana@gmail.comm")).toBe(false);
});
