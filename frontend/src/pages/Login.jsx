function Login() {
  return (
    <div className="flex items-center justify-center h-screen">
      <div className="w-96 p-8 shadow-lg rounded-xl">
        <h1 className="text-3xl font-bold mb-6 text-green-700">
          Login
        </h1>

        <input
          type="email"
          placeholder="Email"
          className="w-full border p-3 mb-4 rounded"
        />

        <input
          type="password"
          placeholder="Password"
          className="w-full border p-3 mb-4 rounded"
        />

        <button className="w-full bg-green-700 text-white p-3 rounded">
          Sign In
        </button>
      </div>
    </div>
  )
}

export default Login