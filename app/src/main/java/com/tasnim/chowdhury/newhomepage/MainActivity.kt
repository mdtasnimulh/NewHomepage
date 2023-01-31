package com.tasnim.chowdhury.newhomepage

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.tasnim.chowdhury.newhomepage.databinding.ActivityMainBinding
import com.tasnim.chowdhury.newhomepage.databinding.FragmentGuestUserBottomSheetBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val list: List<String> = listOf(
        "fasdfdsafsdf",
        "fasdfdsafsdf",
        "fasdfdsafsdf",
        "fasdfdsafsdf",
        "fasdfdsafsdf",
        "fasdfdsafsdf"
    )
    val list2: List<String> = listOf("dsafasdfas", "sdfsdafsadf")

    val currentProgressManageProfile = 60
    val currentProgressVideoResume = 42

    private lateinit var progressBarManageProfile: ProgressBar
    private lateinit var progressBarVideoResume: ProgressBar
    //private lateinit var manageProfileDialogProgressBar: ProgressBar

    private lateinit var recommendJobsRecyclerView: RecyclerView
    private lateinit var recommendJobsAdapter: RecommendJobsAdapter

    private lateinit var favouriteSearchRecyclerView: RecyclerView
    private lateinit var favouriteSearchAdapter: FavouriteSearchAdapter

    private lateinit var interviewInvitationHomePageRecyclerView: RecyclerView
    private lateinit var interviewInvitationHomePageAdapter: InterviewInvitationHomePageAdapter

    private lateinit var bdJobsLearningRecyclerView: RecyclerView
    private lateinit var bdJobsLearningAdapter: BdJobsLearningAdapter

    private lateinit var bdJobsTrendingRecyclerView: RecyclerView
    private lateinit var bdJobsTrendingAdapter: BdJobsTrendingAdapter

    private lateinit var layoutInterviewInvitationsDialog: ConstraintLayout

    private lateinit var openProfile: ImageView
    private lateinit var logoImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //WindowCompat.setDecorFitsSystemWindows(window, false)
//        requestWindowFeature(Window.FEATURE_NO_TITLE)
//        this.window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
//        supportActionBar?.hide()
        //this.window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        setContentView(binding.root)

        val marqueeText = findViewById<TextView>(R.id.mainPageMarquee)
        marqueeText.isSelected = true

        this.window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

//        val windowInsetsController =
//            ViewCompat.getWindowInsetsController(window.decorView)
//
//        windowInsetsController?.isAppearanceLightNavigationBars = true

        // Setting Progress Bar
        progressBarManageProfile = findViewById(R.id.profileCompleteProgressBar)
        progressBarVideoResume = findViewById(R.id.videoResumeProgressBar)
        progressBarManageProfile.progress = currentProgressManageProfile
        progressBarVideoResume.progress = currentProgressVideoResume
        progressBarManageProfile.max = 100
        progressBarVideoResume.max = 100

        // Recycler View For Recommend Jobs
        recommendJobsRecyclerView = findViewById(R.id.recommendJobsRV)
        recommendJobsAdapter = RecommendJobsAdapter()
        recommendJobsRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        recommendJobsRecyclerView.adapter = recommendJobsAdapter

        // Recycler View For Favourite Search
        favouriteSearchRecyclerView = findViewById(R.id.myFavouriteSearchRV)
        favouriteSearchAdapter = FavouriteSearchAdapter()
        favouriteSearchRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        favouriteSearchRecyclerView.adapter = favouriteSearchAdapter

        // Recycler View For Interview Invitation HomePage
        interviewInvitationHomePageRecyclerView = findViewById(R.id.interviewInvitationRv)
        interviewInvitationHomePageAdapter = InterviewInvitationHomePageAdapter()
        interviewInvitationHomePageRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        interviewInvitationHomePageRecyclerView.adapter = interviewInvitationHomePageAdapter

        // Recycler View For BdJobs Learning For Courses
        bdJobsLearningRecyclerView = findViewById(R.id.bdJobsLearningRv)
        bdJobsLearningAdapter = BdJobsLearningAdapter()
        bdJobsLearningRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        bdJobsLearningRecyclerView.adapter = bdJobsLearningAdapter

        // Recycler View For BdJobs Trending
        bdJobsTrendingRecyclerView = findViewById(R.id.bdJobsTrendingRv)
        bdJobsTrendingAdapter = BdJobsTrendingAdapter()
        bdJobsTrendingRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        bdJobsTrendingRecyclerView.adapter = bdJobsTrendingAdapter

        val width = (resources.displayMetrics.widthPixels * 0.97).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.27).toInt()

        // Custom Dialog Box For Interview Invitations
        layoutInterviewInvitationsDialog = findViewById(R.id.invitationsGridCl)
        layoutInterviewInvitationsDialog.setOnClickListener {
            val dialog = Dialog(this)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.interview_invitation_custom_dialog_box)

            val buttonClose = dialog.findViewById<ImageView>(R.id.interviewInvitationDialogCloseIcon)
            buttonClose.setOnClickListener {
                dialog.dismiss()
            }
            dialog.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
            dialog.setCanceledOnTouchOutside(true)

            dialog.findViewById<ConstraintLayout>(R.id.interviewInvitationDialogLiveInterview).setOnClickListener {
                Toast.makeText(this, "Live Interview Invitation Clicked", Toast.LENGTH_SHORT).show()
            }
            dialog.findViewById<ConstraintLayout>(R.id.interviewInvitationDialogOnlineTest).setOnClickListener {
                Toast.makeText(this, "Online Test Invitation Clicked", Toast.LENGTH_SHORT).show()
            }
            dialog.findViewById<ConstraintLayout>(R.id.interviewInvitationDialogVideoInterview).setOnClickListener {
                Toast.makeText(this, "Video Interview Invitation Clicked", Toast.LENGTH_SHORT).show()
            }
            dialog.findViewById<ConstraintLayout>(R.id.interviewInvitationDialogGeneralInterview).setOnClickListener {
                Toast.makeText(this, "General Interview Invitation Clicked", Toast.LENGTH_SHORT).show()
            }

            dialog.show()
        }

        // Bottom Sheet Dialog For Profile Information View
        openProfile = findViewById(R.id.profile_arrow_drop_down)
        logoImage = findViewById(R.id.main_profile_logo)
        openProfile.setOnClickListener {
            bottomSheetDialog()
        }
        logoImage.setOnClickListener {
            bottomSheetDialog()
        }

        binding.categorySeeMore.setOnClickListener {
            val moreIntent = Intent(this, MoreActivity::class.java)
            startActivity(moreIntent)
        }
    }

    private fun bottomSheetDialog(){
        val bottomSheetDialog = BottomSheetDialog(
            this@MainActivity,
        )

        val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
            R.layout.manage_profile_bottom_sheet_layout,
            findViewById(R.id.manageProfileBottomSheetLayout)
        )

        /*bottomSheetView.findViewById<View>(R.id.interviewInvitationDialogCloseIcon).setOnClickListener {
            Toast.makeText(this, "Bottom Sheet Close", Toast.LENGTH_SHORT).show()
            bottomSheetDialog.dismiss()
        }*/

        //val manageProfileDialogBoxCurrentProgress = 65
        //manageProfileDialogProgressBar = bottomSheetDialog.findViewById(R.id.manageProfileDialogProgressBar)!!
        //manageProfileDialogProgressBar.progress = manageProfileDialogBoxCurrentProgress
        //manageProfileDialogProgressBar.max = 100

        bottomSheetDialog.setCanceledOnTouchOutside(true)
        bottomSheetDialog.setContentView(bottomSheetView)
        bottomSheetDialog.show()
    }

}