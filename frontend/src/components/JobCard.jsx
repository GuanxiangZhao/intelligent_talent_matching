function JobCard({ title, company, location, type, salary }) {
  return (
    <div className="border rounded-xl p-6 shadow-md bg-white">
      <h2 className="text-2xl font-bold text-green-700">
        {title}
      </h2>

      <p className="text-gray-800 mt-2">
        {company}
      </p>

      <p className="text-gray-500 mt-1">
        {location}
      </p>

      <div className="flex gap-2 mt-4">
        <span className="bg-green-100 text-green-700 px-3 py-1 rounded-full text-sm">
          {type}
        </span>

        <span className="bg-gray-100 text-gray-700 px-3 py-1 rounded-full text-sm">
          {salary}
        </span>
      </div>

      <button className="mt-5 bg-green-700 text-white px-5 py-2 rounded hover:bg-green-800">
        Apply
      </button>
    </div>
  )
}

export default JobCard