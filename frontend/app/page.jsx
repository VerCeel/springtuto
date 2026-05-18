import StudentTable from "@/components/StudentTable";
import { Button } from "@/components/ui/button";
import Link from "next/link";

export default function Home() {
  return (
    <div className="flex flex-col flex-1 items-center justify-center  font-sans bg-black">
      <main className="flex flex-1 w-full max-w-3xl flex-col items-center justify-between py-32 px-16 sm:items-start">
        <div className="flex justify-between w-full mb-8">
          <h1 className="font-bold text-center sm:text-left">Students</h1>
          <Link href="/projects" className="text-sm text-neutral-500">
            <Button className="mt-4" variant="outline">
              Projects
            </Button>
          </Link>
        </div>
        <StudentTable />
      </main>
    </div>
  );
}
