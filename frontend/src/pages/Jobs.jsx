import JobCard from "../components/JobCard"

function Jobs() {
  const jobs = [
    {
      title: "Frontend Developer",
      company: "Canva",
      location: "Sydney, NSW",
      type: "Full-time",
      salary: "$80k - $100k"
    },
    {
      title: "Backend Engineer",
      company: "Atlassian",
      location: "Melbourne, VIC",
      type: "Full-time",
      salary: "$90k - $120k"
    },
    {
      title: "UI/UX Designer",
      company: "Seek",
      location: "Remote",
      type: "Part-time",
      salary: "$60k - $85k"
    }
  ]

  return (
    <div className="min-h-screen bg-gray-50 p-10">
      <h1 className="text-4xl font-bold text-green-700 mb-2">
        Find your next role
      </h1>

      <p className="text-gray-600 mb-8">
        Browse recommended jobs based on your profile.
      </p>

      <div className="grid grid-cols-1 md:grid-cols-3 gap-6">
        {jobs.map((job, index) => (
          <JobCard
            key={index}
            title={job.title}
            company={job.company}
            location={job.location}
            type={job.type}
            salary={job.salary}
          />
        ))}
      </div>
    </div>
  )
}

export default Jobs