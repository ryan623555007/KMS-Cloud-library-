package com.qiwenshare.file.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qiwenshare.file.domain.UserFile;
import com.qiwenshare.file.vo.file.FileListVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserFileService extends IService<UserFile> {
    List<UserFile> selectUserFileByNameAndPath(String fileName, String filePath, String userId);
    List<UserFile> selectSameUserFile(String fileName, String filePath, String extendName, String userId);

    IPage<FileListVO> userFileList(String userId, String filePath, Long beginCount, Long pageCount);
    IPage<FileListVO> userFileList(String userId, String filePath, String fileName, Long beginCount, Long pageCount);
    void updateFilepathByUserFileId(String userFileId, String newfilePath, String userId);
    void userFileCopy(String userFileId, String newfilePath, String userId);

    IPage<FileListVO> getFileByFileType(Integer fileTypeId, Long currentPage, Long pageCount, String userId);
    IPage<FileListVO> getFileByFileType(Integer fileTypeId, Long currentPage, Long pageCount, String userId, String fileName);
    List<UserFile> selectUserFileListByPath(String filePath, String userId);
    List<UserFile> selectFilePathTreeByUserId(String userId);
    void deleteUserFile(String userFileId, String sessionUserId);

    List<UserFile> selectUserFileByLikeRightFilePath(@Param("filePath") String filePath, @Param("userId") String userId);

}
